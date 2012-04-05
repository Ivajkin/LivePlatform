
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Администратор
 */
public abstract class Text extends ObjectTypes {
protected String[] imageList;
protected String content;

abstract void loadImageList();
abstract void imageDisplay(String imageList);
}
