package sample.Metods;

import java.util.*;

public class BaseTest {
    public ArrayList test = new ArrayList();

    static Collection answer(Collection m) {
        m.add("горький");
        return m;
    }
    static Collection ques(Collection m) {
        m.add("Антоним к слову: Сладкий? ");
        return m;
    }
    static Collection bad(Collection m) {
        m.add("темный");
        m.add("теплый");
        m.add("мокрый");
        return m;
    }

    public ArrayList getAnswer(){
        test.add(answer(new HashSet()));
        return test;
    }
    public void getQues(){
        test.add(ques(new HashSet()));
    }
    public void getBad(){
        test.add(bad(new HashSet()));
    }
}
