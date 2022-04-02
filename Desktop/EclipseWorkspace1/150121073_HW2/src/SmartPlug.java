//Name: Yigit;
//Surname: Tuncer;
//Student Id: 150121073;

import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
    public boolean status;
    public Calendar programTime;
    public boolean programAction;

    public SmartPlug(String alias, String macId) {
        setAlias(alias);
        setMacId(macId);
    }

    public void turnOn() {
        if (isConnectionStatus()) {
            if (!status) {
                Calendar calendar = Calendar.getInstance();
                setStatus(true);
                System.out.println("Smart Plug - " + getAlias() + " is turned on now (Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");
                return;
            }
            System.out.println("Smart Plug - " + getAlias() + " has been already turned on");
        }

    }

    public void turnOff() {
        if (isConnectionStatus()) {
            if (status) {
                Calendar calendar = Calendar.getInstance();
                setStatus(false);
                System.out.println("Smart Plug - " + getAlias() + " is turned off now (Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");
                return;
            }
            System.out.println("Smart Plug - " + getAlias() + " has been already turned off");
        }

    }

    @Override
    public void setTimer(int seconds) {
        if (isConnectionStatus()) {
            //Sets program time to right now.
        	this.programTime = Calendar.getInstance();
        	//Adds seconds to program time.
            programTime.add(Calendar.SECOND, seconds);
            
            Calendar calendar = Calendar.getInstance();
            if (!status) {
                programAction = true;
                System.out.println("Smart plug - " + getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");
            } else {
                programAction = false;
                System.out.println("Smart plug - " + getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ")");

            }

        }

    }

    @Override
    public void cancelTimer() {
        if (isConnectionStatus()){
            programTime = null;
        }

    }

    @Override
    public void runProgram() {
        if (isConnectionStatus()){
            if (isProgramTimeNow()){
            System.out.println("RunProgram -> Smart Plug - " + getAlias());
                if (programAction){
                    turnOn();
                    programTime = null;
                } else {
                    turnOff();
                    programTime = null;
                }
            }
        }

    }

    @Override
    public boolean testObject() {

        if (isConnectionStatus()) {
            System.out.println("Test is starting for SmartPlug");
            smartObjectToString();
            if (status) {
                turnOff();
                turnOn();
            } else {
                turnOn();
                turnOff();
            }
            System.out.println("Test completed for SmartPlug");
            System.out.println(" ");
            return true;
        }
        return false;
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
    public boolean shutDownObject() {
        if (isConnectionStatus()) {
            smartObjectToString();
            if (status) {
                turnOff();
            }
            return true;
        }
        return false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
