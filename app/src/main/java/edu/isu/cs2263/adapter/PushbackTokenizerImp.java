package edu.isu.cs2263.adapter;

public interface PushbackTokenizerImp {
        // Returns the next token
        String nextToken();

        // Returns true if and only if there are more tokens
        boolean hasMoreTokens();

        // The token read is pushed back, so it can be read again using nextToken.
        void pushback();
    }
