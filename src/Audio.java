
public class Audio extends ObjectTypes {

    private String[] bufer;
    private int playTime;
            
    @Override
void getContent(){};
    @Override
void getInfo(){};
    @Override
void transmit(){};
    
    void playAt(int startTime, int time){};
    void setPlayTime(int time){};
}