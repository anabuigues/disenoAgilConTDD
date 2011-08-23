package com.anabuigues.tdd.chapter9;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Splits a string using regex delimiters, optionally keeping the delimiters.
 *
 * In response to a <a href="http://stackoverflow.com/questions/275768">Stackoverflow challenge</a>.
 */
public class Splitter {
    /** Default pattern. */
    private static final Pattern DEFAULT_PATTERN = Pattern.compile("\\s+");

    /** Chosen pattern */
    private Pattern pattern;

    /** Flag for keeping the delimiters */
    private boolean keep_delimiters;

    /**
     * Constructs a new Splitter object.
     * 
     * @param pattern
     *          Pattern to use. Default is '\s+', meaning any whitespace.
     * @param keep_delimiters
     *          Flag to keep delimiters. Default is 'true'.
     */
    public Splitter(Pattern pattern, boolean keep_delimiters) {
        this.pattern = pattern;
        this.keep_delimiters = keep_delimiters;
    }
    public Splitter(String pattern, boolean keep_delimiters) {
        this(Pattern.compile(pattern==null?"":pattern), keep_delimiters);
    }
    public Splitter(Pattern pattern) { this(pattern, true); }
    public Splitter(String pattern) { this(pattern, true); }
    public Splitter(boolean keep_delimiters) { this(DEFAULT_PATTERN, keep_delimiters); }
    public Splitter() { this(DEFAULT_PATTERN); }

    /**
     * Splits a string using the pattern.
     * 
     * @return  Array of strings with each part. If keep_delimiters is active,
     * the indices will contain the matched delimiters.
     */
    public String[] split(String text) {
        if (text == null) {
            text = "";
        }

        int last_match = 0;
        LinkedList<String> splitted = new LinkedList<String>();

        Matcher m = this.pattern.matcher(text);

        // Iterate trough each match
        while (m.find()) {
            // Text since last match
            splitted.add(text.substring(last_match,m.start()));

            // The delimiter itself
            if (this.keep_delimiters) {
                splitted.add(m.group());
            }

            last_match = m.end();
        }
        // Trailing text
        splitted.add(text.substring(last_match));

        return splitted.toArray(new String[splitted.size()]);
    }
}