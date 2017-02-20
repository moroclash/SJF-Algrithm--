/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import java.util.ArrayList;

/**
 *
 * @author mohamedsalah
 */
public class NewClass {
    int n = 0;
    int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] at ;
    int[] bt ;
    double wsum;
    double tsum;

    
    public NewClass(int n)
    {
        this.n=n;
        this.at= new int[n];
        this.bt= new int[n];
    }
    
    
    public void Sorting(int[] at, int[] bt, int n) {
        int temp = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (at[i] < at[j]) {
                    temp = p[j];
                    p[j] = p[i];
                    p[i] = temp;
                    temp = at[j];
                    at[j] = at[i];
                    at[i] = temp;
                    temp = bt[j];
                    bt[j] = bt[i];
                    bt[i] = temp;
                }
            }
        }
        this.at = at;
        this.bt = bt;
    }

    public ArrayList<Integer> Brust() {
        ArrayList<Integer>S=new ArrayList<Integer>();
        S.add(0);
        int btime = 0;
        int temp;
        int min = 0;
        int k = 1;
        for (int j = 0; j < n; j++) {
            btime = btime + bt[j];
            S.add(btime);
            min = bt[k];
            for (int i = k; i < n; i++) {
                if (btime >= at[i] && bt[i] < min) {
                    temp = p[k];
                    p[k] = p[i];
                    p[i] = temp;
                    temp = at[k];
                    at[k] = at[i];
                    at[i] = temp;
                    temp = bt[k];
                    bt[k] = bt[i];
                    bt[i] = temp;
                }
            }
            k++;
        }
        return S;
    }
 
    public String [] Names()
    {
        String []x=new String[this.n];
        for(int i=0;i<n;i++)
        {
            x[i]="P"+p[i];
        }
        return x;
    }
    
    
    public int[] WT() {
        int wt[] = new int[this.n];
        int sum = 0;
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            sum = sum + bt[i - 1];
            wt[i] = sum - at[i];
            wsum = wsum + wt[i];
        }
        return wt;
    }

    public double wavg() {
        return (wsum / n);
    }

    public int[] Turnaround_Time() {
        int ta = 0;
        int tt[] = new int[this.n];
        for (int i = 0; i < n; i++) {
            ta = ta + bt[i];
            tt[i] = ta - at[i];
            tsum = tsum + tt[i];
        }
        return tt;
    }
    public double twavg()
    {
        return (tsum/n);
    }

}

