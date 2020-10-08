
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Classe che si occupa di verificare i dati.
 * 
 * @author alessandro.aloise
 * @version 08.10.2020
 */
public class CheckData {

    /**
     * Controlla con un espressione regolare se la nome rispetta i parametri messi.
     * 
     * @param name la nome da controllare
     * @return ritorna true se il nome va bene oppure false se il nome non va bene.
     */
    public boolean isRegularName(String name) {
        String expression = "^[a-zA1-9\\s]+"; 
        return name.matches(expression);        
    }
    
    
    /**
     * Controlla con un espressione regolare se la nome rispetta i parametri messi.
     * 
     * @param name la nome da controllare
     * @return ritorna true se il nome va bene oppure false se il nome non va bene.
     */
    public boolean isRegularNameUtente(String name) {
        String expression = "^[a-zA+.+1-9\\s]+"; 
        return name.matches(expression);        
    }
    
    /**
     * Controlla con un espressione regolare se la password rispetta i parametri messi.
     * 
     * @param pass la password da controllare
     * @return ritorna true se la password va bene oppure false se la password non va bene.
     */
    public boolean isRegularPassword( String pass){
        String expression = "^(?=.*[0-9]).{6,15}$";
         return pass.matches(expression);  
    }
    
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    private boolean isRegularEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}
    
    public void alert(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    
    
    /**
     *  Metodo che si occupa di controllare che sia il nome che la password rispettino i parametri. 
     * 
     * @param nome nome utente
     * @param password password dell'utente.
     */
    public boolean chekRules( String nome, String password){
        if (isRegularNameUtente(nome) && isRegularPassword(password)) {
            System.out.println("dati valdi");
            return true;
        } else {
            alert("Nome utente o password non validi");
            return false;
        }  
    }
    
    
    public boolean register(String nome, String cognome, String nomeUtente, String email, String password){
        if( isRegularName(nome)== true &&isRegularName(cognome)== true &&  isRegularNameUtente(nomeUtente)== true && isRegularEmail(email)== true && isRegularPassword(password) == true ){
            return true;
        }else{
            return false;
        }
    }
    
    
    public void validity(){
        
    }
    
}
