//Name: Yigit;
//Surname: Tuncer;
//Student Id: 150121073;

import java.util.ArrayList;
import java.util.Arrays;

public class SmartHome {
    ArrayList<SmartObject> smartObjectList = new ArrayList<>();

    public SmartHome() {

    }

    public boolean addSmartObject(SmartObject smartObject) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Adding new SmartObject");
        System.out.println("--------------------------------------------------------------------------");
        if (smartObjectList.contains(smartObject)) {
            return false;
        } else {
            //Creates ip address;
            String s = "10.0.0.";
            smartObjectList.add(smartObject);
            s += String.valueOf(100 + smartObjectList.indexOf(smartObject));
            smartObject.connect(s);
            smartObject.testObject();
            return true;
        }


    }

    public boolean removeSmartObject(SmartObject smartObject) {
        if (smartObjectList.contains(smartObject)) {
            smartObjectList.remove(smartObject);
            return true;
        } else {
            return false;
        }

    }

    public void controlLocation(boolean onCome) {

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("LocationControl: OnCome");
        System.out.println("--------------------------------------------------------------------------");
        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof LocationControl) {
                if (onCome) {
                    ((LocationControl) smartObject).onCome();
                } else {
                    ((LocationControl) smartObject).onLeave();
                }
            }
        }
    }

    public void controlMotion(boolean hasMotion, boolean isDay) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("MotionControl: HasMotion, isDay");
        System.out.println("--------------------------------------------------------------------------");
        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof MotionControl) {
                ((MotionControl) smartObject).controlMotion(hasMotion, isDay);
            }
        }

    }

    public void controlProgrammable() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: runProgram");
        System.out.println("--------------------------------------------------------------------------");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof Programmable) {
                ((Programmable) smartObject).runProgram();
            }
        }
    }

    public void controlTimer(int seconds) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: Timer = " + seconds + " seconds");
        System.out.println("--------------------------------------------------------------------------");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof Programmable) {
                if (seconds > 0) {
                    ((Programmable) smartObject).setTimer(seconds);
                } else if (seconds == 0) {
                    ((Programmable) smartObject).cancelTimer();
                }
            }
        }
    }

    public void controlTimerRandomly() {

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: Timer = 0, 5 or 10 seconds randomly");
        System.out.println("--------------------------------------------------------------------------");

        //Randomly generate number from 1 to 3;
        for (SmartObject smartObject : smartObjectList) {
            int i = (int) ((Math.random() * 3.0) + 1);
            if (smartObject instanceof Programmable) {
                switch (i) {

                    case 1:
                        ((Programmable) smartObject).cancelTimer();
                        break;
                    case 2:
                        ((Programmable) smartObject).setTimer(5);
                        break;
                    case 3:
                        ((Programmable) smartObject).setTimer(10);
                }

            }
        }
    }

    public void sortCameras() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort Smart Cameras");
        System.out.println("--------------------------------------------------------------------------");
        ArrayList<SmartCamera> smartCamerasArrayList = new ArrayList<>();
        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof Comparable) {
                smartCamerasArrayList.add((SmartCamera) smartObject);
            }
        }
        SmartCamera[] smartCameras = new SmartCamera[smartCamerasArrayList.size()];
        for (int i = 0; i < smartCamerasArrayList.size(); i++) {
            smartCameras[i] = smartCamerasArrayList.get(i);
        }
        Arrays.sort(smartCameras);
        for (SmartCamera smartCamera : smartCameras) {
            System.out.println(smartCamera.toString());
        }

    }

    public ArrayList<SmartObject> getSmartObjectList() {
        return smartObjectList;
    }

    public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
        this.smartObjectList = smartObjectList;
    }
}
