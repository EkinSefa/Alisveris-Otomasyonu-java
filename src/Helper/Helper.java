
package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Helper {
    
    
    public static void optionPaneChangeButtonText(){
        UIManager.put("OptionPane.cancelButtonText", "İptal");
        UIManager.put("OptionPane.nolButtonText", "Hayır");
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
    }
 
public static void showMsg(String str){
    String msg;
    optionPaneChangeButtonText();
    switch(str){
        case "fill":
            msg="Lütfen Tüm Alanları Doldurun";
            break;
        case "success":
            msg="İşlem  Başarılı";
            break;
            default:
                msg=str;
    }
    JOptionPane.showMessageDialog(null, msg,"Mesaj",JOptionPane.INFORMATION_MESSAGE);
            
    
}

public static boolean confirm(String str){
    String msg;
    switch(str){
        case"sure":
            msg ="Bu işlemden emin misin ?";
            break;
            
            default:
                msg=str;
                break;
            
    }
    int rs=JOptionPane.showConfirmDialog(null, msg,"Dikkat !!",JOptionPane.YES_NO_OPTION);
    if (rs==0) {
        return true;
    }else{
        return false;
    }
    
}
}
