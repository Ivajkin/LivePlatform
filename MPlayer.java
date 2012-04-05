
/**
 *
 * @author Администратор
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.media.*;

public class MPlayer extends JPanel {
    //<editor-fold defaultstate="collapsed" desc="comment">    
 
   private Player player;
   private File file;

   public MPlayer()
   { 
      createPlayer();
      setSize( 300, 300 );
      file= new File("test.avi");  //file:/D:/IDE/NetBeans 7.1/Projects/TESTS/test.avi
   }

   private void createPlayer()
   {
      removePreviousPlayer();

      try {
         // create a new player and add listener
          System.out.print(file.toURL());
         player = Manager.createPlayer(file.toURL());
         player.addControllerListener( new EventHandler() );
         player.start();  // start player
      }
      catch ( Exception e ){
         /*JOptionPane.showMessageDialog( this,
            "Invalid file or location", "Error loading file",
            JOptionPane.ERROR_MESSAGE );*/
      }
   }

   private void removePreviousPlayer()
   {
      if ( player == null )
         return;

      player.close();

      removeAll();
   }

  // inner class to handler events from media player
   private class EventHandler implements ControllerListener {
        @Override
      public void controllerUpdate( ControllerEvent e ) {
         if ( e instanceof RealizeCompleteEvent ) {
         
            // load Visual and Control components if they exist
            Component visualComponent =
               player.getVisualComponent();

            if ( visualComponent != null )
               add( visualComponent, BorderLayout.CENTER );

            Component controlsComponent =
               player.getControlPanelComponent();

            if ( controlsComponent != null )
               add( controlsComponent, BorderLayout.SOUTH );

            doLayout();
         }
      }
   }//</editor-fold>
}

