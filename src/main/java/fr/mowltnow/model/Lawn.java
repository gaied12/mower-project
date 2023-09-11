package fr.mowltnow.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
@Getter
@AllArgsConstructor
@Setter
public class Lawn {
    private  List<Mower> mowerList=new ArrayList<>();
    private  Grid gridMaxSize;
    private  static Lawn instance;

    public static Lawn getInstance() {
        if (instance == null) {
            instance = new Lawn();
        }
        return instance;
    }


private Lawn(){}
}
