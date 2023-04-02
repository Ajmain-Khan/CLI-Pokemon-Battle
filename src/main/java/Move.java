public class Move {
    private String name;
    private String type;
    private int power;
    private float accuracy;

    //Constructor
    public Move(String name, String type, int power, float accuracy){
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }

    // Accessors
    public String get_name(){   // Returns move name
        return name;
    }
    public String get_type(){   // Returns move element type
        return type;
    }
    public int get_power(){ // Returns move power
        return power;
    }
    public float get_accuracy(){    // Returns hit accuracy of move
        return accuracy;
    }
}