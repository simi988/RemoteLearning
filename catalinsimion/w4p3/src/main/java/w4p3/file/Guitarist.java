package w4p3.file;

import java.util.List;

public class Guitarist {

    public List<LeadGuitarist> leadGuitarist;
    public  List<RhythmGuitarist> rhythmGuitarist;
    public  List<BassGuitarist> bassGuitarist;
    public   List<Guitar> guitar;




    public List<LeadGuitarist> getLeadGuitarists(){
        return leadGuitarist;
    }
    public List<RhythmGuitarist> getRhythmGuitarists(){
        return rhythmGuitarist;
    }
    public List<BassGuitarist> getBassGuitarists(){
        return bassGuitarist;
    }
    public List<Guitar> getGuitars(){
        return guitar;
    }
}
