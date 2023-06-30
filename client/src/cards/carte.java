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
public class carte {
    private carta first;
    private int elementi;
    public carte()
    {
        first=null;
        elementi=0;
    }
    public void inserisciInizio(tipo info)
    {
        carta nn=new carta(info);
        nn.setLink(first);
        first=nn;
        elementi++;
    }
    public void inserisciFine(tipo info)
    {
        carta p=first;
        if (first==null)
            inserisciInizio(info);
        else
        {
            while(p.getLink()!=null)
                p=p.getLink();
            carta nn=new carta(info);
            nn.setLink(null);
            p.setLink(nn);
            elementi++;
        }
    }
    public void inserisciDove(int dove,tipo info)
    {
        int i;
        carta nn=first;
        if(dove>elementi)
            dove=elementi;
        for(i=1;i<dove;i++)
        {
            nn=nn.getLink();
        }
        carta crea=new carta(info);
        crea.setLink(nn.getLink());
        nn.setLink(nn);
    }
    public void eliminaInizio()
    {
        if(first==null)
            return;
        first=first.getLink();
        elementi--;
    }
    public void eliminaFine()
    {
        if(first==null)
            return;
        carta n1=first,n2=first;
        while(n1.getLink()!=null)
        {
            n2=n1;
            n1=n1.getLink();
        }
        n2.setLink(null);
        elementi--;
    }
    public void eliminaDove(int dove)
    {
        int i;
        carta n1,nn=first;
        if(dove>elementi)
            dove=elementi;
        for(i=1;i<dove;i++)
        {
            nn=nn.getLink();
        }
        n1=nn.getLink();
        nn.setLink(n1.getLink());
    }
    public tipo getValue(int n)
    {
        int i;
        carta c=first;
        for(i=0;i<n;i++)
            c=c.getLink();
        tipo inf=c.getInfo();
        eliminaDove(n);
        return inf;
    }
}

