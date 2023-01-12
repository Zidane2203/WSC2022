package ktp_20190140083.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author yusuf
 */
@Controller
@ResponseBody
@CrossOrigin
public class myController {

    Kartutandapenduduk data = new Kartutandapenduduk();
    KartutandapendudukJpaController dctrl = new KartutandapendudukJpaController();  
 
    @RequestMapping("/GET")    
    public String get(){
        List<Kartutandapenduduk> datas = new ArrayList<>();
        try {datas = dctrl.findKartutandapendudukEntities();} 
        catch (Exception error) {}
        return datas.toString();
    }   
    
    @RequestMapping(value="/POST",method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public String postData(HttpEntity<String> kiriman) throws JsonProcessingException{  
        
        String message = "no action";
        String json_receive = kiriman.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Kartutandapenduduk newdata = new Kartutandapenduduk();
        newdata = mapper.readValue(json_receive, Kartutandapenduduk.class);
        try {
            dctrl.create(newdata);
            message = newdata.getNama()+ " saved";
        } catch (Exception ex) {
            Logger.getLogger(myController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    @RequestMapping(value="/PUT",method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public String putData(HttpEntity<String> kiriman) throws JsonProcessingException{  
        
        String message = "no action";
        String json_receive = kiriman.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Kartutandapenduduk newdata = new Kartutandapenduduk();
        newdata = mapper.readValue(json_receive, Kartutandapenduduk.class);
        try {
            dctrl.create(newdata);
            message = newdata.getNama()+ " saved";
        } catch (Exception ex) {
            Logger.getLogger(myController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    @RequestMapping(value="/DELETE",method = RequestMethod.DELETE, consumes = APPLICATION_JSON_VALUE)
    public String deleteData(@PathVariable("id") int id) throws Exception{  
        String message = "Data has been deleted";
        try {
            dctrl.destroy(id);
        }
        catch (Exception e){
            message = "Delete Failed";
        }
        return message;
    }
}
