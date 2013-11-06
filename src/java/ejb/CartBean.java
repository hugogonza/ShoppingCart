/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author HugoCésar
 */
@Stateful
public class CartBean {

    List<String> contents = new ArrayList<>();
    
    public void add(String merchandise){
        contents.add(merchandise);
        
    }
    
    public void delete(String merchandise){
        contents.remove(merchandise);
    }
    
    public List<String> getContents(){
    
    return contents;
    }
}
