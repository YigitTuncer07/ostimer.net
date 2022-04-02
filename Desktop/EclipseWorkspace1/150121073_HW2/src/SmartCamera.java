//Name: Yigit;
//Surname: Tuncer;
//Student Id: 150121073;

public class SmartCamera extends SmartObject implements Comparable<SmartCamera>, MotionControl {
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
        setAlias(alias);
        setMacId(macId);
        this.nightVision = nightVision;
        this.batteryLife = batteryLife;
    }

    public SmartCamera() {
        this("COMPARE_CAMERA","COMPARE_CAMERA",true,100);
    }

    public void recordOn(boolean isDay) {
        if (isConnectionStatus()) {
            if (isDay) {
                if (status) {
                    System.out.println("Smart Camera - " + getAlias() + " has been already turned on");
                } else {
                    System.out.println("Smart Camera - " + getAlias() + " is turned on now");
                    status = true;
                }
            } else {
                if (status) {
                    System.out.println("Smart Camera - " + getAlias() + " has been already turned on");
                } else {
                    if (!nightVision) {
                        System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature.");
                    } else {
                        System.out.println("Smart Camera - " + getAlias() + " is turned on now");
                        status = true;
                    }
                }
            }
        }


    }

    public void recordOff() {
        if (isConnectionStatus()) {
            if (status) {
                setStatus(false);
                System.out.println("Smart Camera - " + getAlias() + " is turned off now");
                return;
            }
            System.out.println("Smart Camera - " + getAlias() + " has been already turned off");
        }

    }


    @Override
    public String toString() {
        String statusString = null;
        if (status){
            statusString = "recording";
        } else{
            statusString = "not recording";
        }
        return "SmartCamera -> " + getAlias() + "'s battery life is " + getBatteryLife() + " status is " + statusString;
    }

    @Override
    public boolean controlMotion(boolean hasMotion, boolean isDay) {
        if (!hasMotion) {
            System.out.println("Motion not detected");
            return true;
        } else {
            System.out.println("Motion detected!");
            if (isDay) {
                recordOn(true);
                return true;
            } else {
                if (nightVision) {
                    recordOn(false);
                    return true;
                }


            }
        }
        return false;
    }

    @Override
    public boolean testObject() {
        if (isConnectionStatus()) {
            System.out.println("Test is starting for SmartCamera");
            smartObjectToString();
            System.out.println("Test is starting for SmartCamera day time");
            recordOn(true);
            recordOff();
            System.out.println("Test is starting for SmartCamera night time");
            recordOn(false);
            recordOff();
            System.out.println("Test completed for SmartCamera");
            System.out.println(" ");
            return true;
        }
        return false;
    }

    @Override
    public boolean shutDownObject() {
        if (isConnectionStatus()) {
            smartObjectToString();
            if (status) {
                recordOff();
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

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }


    @Override
    public int compareTo(SmartCamera smartCamera) {
        if (smartCamera.getBatteryLife() > this.batteryLife){
            return -1;
        } else if (smartCamera.getBatteryLife() == this.batteryLife){
            return 0;
        } else {
            return 1;
        }
    }
}
