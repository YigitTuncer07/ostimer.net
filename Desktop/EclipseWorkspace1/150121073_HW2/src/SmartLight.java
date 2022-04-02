//Name: Yigit;
//Surname: Tuncer;
//Student Id: 150121073;

import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable {

    private boolean hasLightTurned;
    private Calendar programTime;
    private boolean programAction;

    public SmartLight(String alias, String macId) {
        super();
        super.setAlias(alias);
        super.setMacId(macId);
    }

    public void turnOnLight() {
        Calendar calendar = Calendar.getInstance();
        if (!hasLightTurned) {
            this.hasLightTurned = true;
            System.out.println("Smart Light - " + getAlias() + " is turned on now (Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");
            return;
        }
        System.out.println("Smart Light - " + getAlias() + " has been already turned on");
    }

    public void turnOffLight() {
        Calendar calendar = Calendar.getInstance();
        if (hasLightTurned) {
            this.hasLightTurned = false;
            System.out.println("Smart Light - " + getAlias() + " is turned off now (Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");
            return;
        }
        System.out.println("Smart Light - " + getAlias() + " has been already turned off");
    }

    @Override
    public void onLeave() {
        System.out.println("On Leave -> Smart Light - " + getAlias());
        if (hasLightTurned) {
            turnOffLight();
        }
    }

    @Override
    public void onCome() {
        System.out.println("On Come -> Smart Light - " + getAlias());
        if (!hasLightTurned) {
            turnOnLight();
        }
    }

    @Override
    public void setTimer(int seconds) {
        if (isConnectionStatus()) {
            this.programTime = Calendar.getInstance();
            this.programTime.add(Calendar.SECOND, seconds);
            Calendar calendar = Calendar.getInstance();
            if (hasLightTurned) {
                programAction = false;
                System.out.println("Smart light - " + getAlias() + " will be turned off " + seconds + " seconds later!" + " " + "(Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");
            } else {
                programAction = true;
                System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds + " seconds later!" + " " + "(Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");
            }
        }

    }

    @Override
    public void cancelTimer() {
        if (isConnectionStatus()) {
            setProgramTime(null);
        }

    }

    @Override
    public void runProgram(){
        if(isConnectionStatus()){
            if(isProgramTimeNow()){
                System.out.println("RunProgram -> Smart Light - " + getAlias());
                if(programAction){
                    turnOnLight();;
                    setProgramTime(null);
                } else {
                    turnOffLight();
                    setProgramTime(null);
                }
            }
        }
    }
    //CHECKS IF THE TIME OF THE PROGRAM IS EQUAL TO THE CURRENT TIME
    public Boolean isProgramTimeNow() {
        try {
            Calendar calendar = Calendar.getInstance();
            String programTimeString = this.programTime.get(Calendar.HOUR) + ":" + this.programTime.get(Calendar.MINUTE) + ":" + this.programTime.get(Calendar.SECOND);
            String currentTime = calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
            return programTimeString.equals(currentTime);
        } catch (NullPointerException nullPointerException){
            return false;
        }
    }

    @Override
    public boolean testObject() {
        System.out.println("Test is starting for SmartLight");
        smartObjectToString();
        if (isConnectionStatus()) {
            if (hasLightTurned) {
                turnOffLight();
                turnOnLight();
                System.out.println("Test completed for SmartLight");
                System.out.println(" ");
                return true;
            }
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight");
            System.out.println(" ");
            return true;
        }
        return false;
    }

    @Override
    public boolean shutDownObject() {
        if (isConnectionStatus()) {
            smartObjectToString();
            if (hasLightTurned) {
                turnOffLight();
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean isHasLightTurned() {
        return hasLightTurned;
    }

    public void setHasLightTurned(boolean hasLightTurned) {
        this.hasLightTurned = hasLightTurned;
    }

    public Calendar getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

    public boolean isProgramAction() {
        return programAction;
    }

    public void setProgramAction(boolean programAction) {
        this.programAction = programAction;
    }
}
