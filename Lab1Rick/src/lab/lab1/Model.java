package lab.lab1;

/**
 * @author
 */
public class Model {
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


    private String firstName;
    private String lastName;
    private int height_inches;
    private double weight_pounds;
    private boolean canTravel;
    private boolean smokes;

    Model(String f, String l, int h, double w, boolean c, boolean s) {
        if (f.length() >= 3 && f.length() <= 20) {
            this.firstName = f;
        } else {
            this.firstName = null;
        }
        if (l.length() >= 3 && l.length() <= 20) {
            this.lastName = l;
        } else {
            this.lastName = null;
        }
        if (h >= 24 && h <= 84) {
            this.height_inches = h;
        } else {
            this.height_inches = 0;
        }
        if (w >= 80 && w <= 280) {
            this.weight_pounds = w;
        } else {
            this.weight_pounds = 0;
        }
        this.canTravel = c;
        this.smokes = s;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return height_inches
     */
    public int getHeight_inches() {
        return height_inches;
    }

    /**
     * @return weight_pounds
     */
    public double getWeight_pounds() {
        return weight_pounds;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param height_inches
     */
    public void setHeight_inches(int height_inches) {
        this.height_inches = height_inches;
    }

    /**
     * @param weight_pounds
     */
    public void setWeight_pounds(double weight_pounds) {
        this.weight_pounds = weight_pounds;
    }

    /**
     * @param canTravel
     */
    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    /**
     * @param smokes
     */
    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    public String getHeightInFeetAndInches() {
        int feet = height_inches / INCHES_PER_FOOT;
        int inches = height_inches % INCHES_PER_FOOT;
        if (inches == 0) {
            return feet + " feet";
        } else if (inches == 1) {
            return feet + " feet " + inches + " inch";
        } else {
            return feet + " feet " + inches + " inches";
        }
    }

    public long getWeightKg() {
        long kg = (long) (weight_pounds / POUNDS_PER_KG);
        return Math.round(kg);
    }

    public void setWeight(long kilograms) {
        this.weight_pounds = kilograms;
    }

    public void setHeight(int feet, int inches) {
        this.height_inches = feet + inches;
    }

    public void printDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeight_inches() + " inches");
        System.out.println("Weight: " + Math.round(getWeight_pounds()) + " pounds");
        if (canTravel) {
            System.out.println("Does travel");
        } else {
            System.out.println("Does not travel");
        }
        if (smokes) {
            System.out.println("Does smoke");
        } else {
            System.out.println("Does not smoke");
        }
    }

    public int calculatePayDollarsPerHour() {
        if (height_inches >= TALL_INCHES && weight_pounds <= THIN_POUNDS) {
            if (canTravel) {
                if (smokes) {
                    return BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR +
                            TRAVEL_BONUS_DOLLARS_PER_HOUR - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
                } else {
                    return BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR +
                            TRAVEL_BONUS_DOLLARS_PER_HOUR;
                }
            } else {
                if (smokes) {
                    return BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR -
                            SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
                } else {
                    return BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR;
                }
            }
        } else if (height_inches < TALL_INCHES || weight_pounds > THIN_POUNDS) {
            if (canTravel) {
                if (smokes) {
                    return BASE_RATE_DOLLARS_PER_HOUR + TRAVEL_BONUS_DOLLARS_PER_HOUR -
                            SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
                } else {
                    return BASE_RATE_DOLLARS_PER_HOUR + TRAVEL_BONUS_DOLLARS_PER_HOUR;
                }
            } else {
                if (smokes) {
                    return BASE_RATE_DOLLARS_PER_HOUR - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
                }
            }
        }
        return BASE_RATE_DOLLARS_PER_HOUR;
    }

    public void displayModelDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeightInFeetAndInches());
        System.out.println("Weight: " + getWeight_pounds() + " pounds");
        if (canTravel) {
            System.out.println("Travels: yep");
        } else {
            System.out.println("Travels: nope ");
        }
        if (smokes) {
            System.out.println("Smokes: yep");
        } else {
            System.out.println("Smokes: nope");
        }
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());
    }
}
