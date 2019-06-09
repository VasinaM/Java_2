package lesson2_3;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Phonebook {
    HashMap<String, List<String>> hm;

    public Phonebook () {
        this.hm = new HashMap<>();
    }
    public void addContakt (String name, String phonnumber) {
        HashMap <String, String> telebook = hm.getOrDefault(name, new HashSet<>());
        telebook.add(phonnumber);
    }
}
