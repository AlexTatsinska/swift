
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class GamerGroup {
    String groupName;
    List<Gamer> groupGamers;

    public GamerGroup(String groupName) {
        this.groupName = groupName;
    }

    public GamerGroup(String groupName, List<Gamer> groupGamers) {
        setGroupName(groupName);
        setGroupGamers(groupGamers);
    }

    public void setGroupName(String groupName) {
        setGroupName(groupName);
    }

    public void setGroupGamers(List<Gamer> groupGamers) {
        this.groupGamers = groupGamers;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Gamer> getGroupGamers() {
        return groupGamers;
    }
    
    public void addGamer(Gamer gamer){
        groupGamers.add(gamer);
    }
    
}
