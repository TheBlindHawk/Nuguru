/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

/**
 *
 * @author user
 */
public class carta {
    private tipo info;
    private carta link;
    public carta (tipo oggetto)
    {
        info =oggetto;
        link=null;
    }
    public void setInfo(tipo oggetto)
    {
        info=oggetto; 
    }
    public tipo getInfo()
    {
        return info;
    }
    public void setLink(carta link)
    {
        this.link=link;
    }
    public carta getLink()
    {
        return link;
    }
}

