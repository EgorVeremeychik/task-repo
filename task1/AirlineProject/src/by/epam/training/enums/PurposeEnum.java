package by.epam.training.enums;

/**
 * Created by EgorVeremeychik on 17.10.2015.
 */
public enum PurposeEnum{
    FIGHTER{
        {this.value="istrebitel";}
    },
    INTERCEPTOR{
        {this.value="perehvatchik";}
    },
    BOMBER{
        {this.value="bombardirovshik";}
    },
    STORMTROOPER{
        {this.value="shturmivik";}
    };

    String value;

    public String getValue() {
        return this.value;
    }


}

