package com.leony.home;

public class StringGames {
    private String word;

    public StringGames(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return this.word;
    }

    public void setWordUsingValueOf(Integer wordAsInt) {
        this.word = String.valueOf(wordAsInt);
    }

    public void setWordUsingConcat(String word) {
        this.word = this.word.concat(word);
    }

    public void setWordUsingReplace(String word) {
        this.word = this.word.replace("111", word);
    }

    public void setWordToLowerCase() {
        this.word = this.word.toLowerCase();
    }

    public void setWordToUpperCase() {
        this.word = this.word.toUpperCase();
    }

    public void setWordAsTrim() {
        this.word = this.word.trim();
    }

    public void setWordAsSplitAndJoin(String wordToSplitBy, String wordToJoinWith) {
        String[] splitParts = this.word.split(wordToSplitBy);
        this.word = String.join(wordToJoinWith, splitParts);
    }

    public String setWordAsFormat(String wordToAddToFormat) {
        return String.format("The value of word is %s, and the added word is %s", this.word, wordToAddToFormat);
    }

    public char setWordAsCharAt(int position) {
        return this.word.charAt(position);
    }

    public String setWordAsSubString(int startPosition, int endPosition) {
        return this.word.substring(startPosition, endPosition);
    }

    public String setWordAsStringBuilder(String[] words, int positionToInsert) {
        StringBuilder sb = new StringBuilder(100);
        for (String word : words) {
            sb.append(word);
        }
        sb.insert(positionToInsert, this.word);
        return sb.toString();
    }
}
