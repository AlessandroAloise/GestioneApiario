
# GestioneApiario | Diario di lavoro
##### [Alessandro Aloise]
### [CPT Trevano], [22.10.20]

## Lavori svolti


|Orario        |Lavoro svolto                                   |
|--------------|------------------------------------------------|
|10:05 - 11:35 |ricerche per come creare il calendario          |
|12:30 - 13:15 |prova di creazione di un calendario                 |
|13:20 - 15:30 |aggiungere alla lista delle arine altre arnie con il tasto|
|15:30 - 15:45 |Creazione diario                                |


##  Problemi riscontrati e soluzioni adottate
-passare un infromazione un "pop up " di discussione a una classe, l'errore era che istanziabvo un oggetto che non dovevo e di consegnueza la lista non si aggiornava. 

questo é stato messo nel ArniaDialog
'
private void raiseChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "arina", false, testo.getText());
        PropertyChangeListener[] listeners = this.getPropertyChangeListeners();
        synchronized (listeners) {
            for (PropertyChangeListener e : listeners) {
                e.propertyChange(event);
            }
        }
    }
    
'

mentre questo lo messo nel panel
'
    private void arniaBActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Frame JFrame_Apiaroi = null;
        ArniaDialog d = new ArniaDialog(JFrame_Apiaroi);
        d.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                arinaDialogPropertyChange(evt);
            }
        });        
        d.setVisible(true);
    }                                      

    private void arinaDialogPropertyChange(java.beans.PropertyChangeEvent evt) {                                         
        if ("arina".equals(evt.getPropertyName())) {
           addList((String) evt.getNewValue());
        }
    }  
 
'

##  Punto della situazione rispetto alla pianificazione
in orario

## Programma di massima per la prossima giornata di lavoro
finire la creazione del sistema di log e finire di mettere in realzione i due  jPanel 