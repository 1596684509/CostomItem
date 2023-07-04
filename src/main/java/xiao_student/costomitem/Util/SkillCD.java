package xiao_student.costomitem.Util;

import java.util.Timer;
import java.util.TimerTask;

public class SkillCD {

    private int CD;
    private int firstCD;
    private boolean firstCd = true;
    private boolean CDOver = true;

    public void setCD(int CD) {
        this.CD = CD;
        this.firstCD = CD;
    }

    public int getCD() {
        return CD;
    }

    public void setFirstCd(boolean firstCd) {
        this.firstCd = firstCd;
    }

    public boolean isFirstCd() {
        return firstCd;
    }

    public void reduceCD() {

        CD--;

    }

    public void setCDOver(boolean CDOver) {
        this.CDOver = CDOver;
    }

    public boolean isCDOver() {
        return CDOver;
    }

    public int getFirstCD() {
        return firstCD;
    }

    public void cdStart() {

        setCDOver(false);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                reduceCD();

                if(getCD() == 0) {

                    setCDOver(true);
                    setCD(getFirstCD());
                    this.cancel();

                }

            }
        }, 0, 1000l);

    }

}
