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
public class creaCarte {
    carte cards=new carte();
    public creaCarte(int n)
    {
        tipo num[]=new tipo [n];
        int i;
        for(i=0;i<n;i++){
            num[i]=new tipo((i%(n/4))+1,(i/(n/4))+1);
            System.out.println((i%(n/4))+1+"+"+((i/(n/4))+1));
        }
        for (i=0;i<n;i++)
            cards.inserisciFine(num[i]);
    }
    public tipo getCard(int n)
    {
        return cards.getValue(n);
    }
}
