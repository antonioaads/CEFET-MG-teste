package Item;

/**
 * @author Ziviani
 */
public class Item {
    private int chave;
    
    public Item(int chave) {
        this.chave = chave;
    }
    
    public int compara(Item it) {
        Item item = it;
        if (this.chave < item.chave)
        return -1;
        else if (this.chave > item.chave)
        return 1;
        return 0;
    }

    public int getChave() {return chave;}
    
    
    // Específico para a implementação do heap do ziviani
    public Object recuperaChave () { return new Integer (this.chave); }
    
    public void alteraChave (Object chave) {
    Integer ch = (Integer) chave; this.chave = ch.intValue ();
    }
}