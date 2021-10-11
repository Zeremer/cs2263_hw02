package edu.isu.cs2263.adapter;

import java.util.StringTokenizer;

public class PushbackTokenizer implements PushbackTokenizerImp {

    // Variables
    StringTokenizer st;
    String last = "";
    String next = "";
    String pBack = "";

    // Returns the next token
    public String nextToken(){
        String send;
        if(pBack == ""){
            send = next;
            last = next;
            if(st.hasMoreTokens()){
                next = st.nextToken();
            }else{
                next = "";
            }
        }else{
            send = pBack;
            last = pBack;
            pBack = "";
        }
        return send;
    }

    // Returns true if and only if there are more tokens
    public boolean hasMoreTokens(){
        if(pBack == "" && next == ""){
            return false;
        }
        return true;
    }

    // The token read is pushed back, so it can be read again using nextToken.
    public void pushback(){
            pBack = last;
    }

    // Constructor
    public PushbackTokenizer(String str){
        this.st = new StringTokenizer(str);
        this.next = st.nextToken();
    }
}
