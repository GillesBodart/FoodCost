/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.objets.dialogs;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Gilles
 */
public class MonJFileChooser extends JFileChooser {

    String url;
    String nom;
    
    
    private void init(){
        this.setApproveButtonText("Enregistrer dans");
        this.setDialogTitle("Choix du dossier");
        this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.setAcceptAllFileFilterUsed(false);
    }
    
    public MonJFileChooser() {
        super();
        init();
    }

    public MonJFileChooser(String currentDirectoryPath) {
        super(currentDirectoryPath);
        init();
    }

    public MonJFileChooser(File currentDirectory) {
        super(currentDirectory);
        init();
    }

    public MonJFileChooser(FileSystemView fsv) {
        super(fsv);
        init();
    }

    public MonJFileChooser(File currentDirectory, FileSystemView fsv) {
        super(currentDirectory, fsv);
        init();
    }

    public MonJFileChooser(String currentDirectoryPath, FileSystemView fsv) {
        super(currentDirectoryPath, fsv);
        init();
    }

    public String getUrl() throws IOException {
        if (this.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            url =getSelectedFile().getAbsolutePath();
        }
        return url;
    }
}
