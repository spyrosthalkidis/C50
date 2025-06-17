package com.distributed.c50.model;

/**
 * Class representing metadata about an attribute.
 * Standalone implementation to avoid compilation issues with inner classes.
 */
public class AttributeMetadata {
    public static final int TYPE_NOMINAL = 1;
    public static final int TYPE_NUMERIC = 0;
    
    private final String name;
    private final int type;
    private final int numValues;
    
    /**
     * Creates new attribute metadata.
     * 
     * @param name the attribute name
     * @param type the attribute type (TYPE_NOMINAL or TYPE_NUMERIC)
     * @param numValues the number of distinct values (for nominal attributes)
     */
    public AttributeMetadata(String name, int type, int numValues) {
        this.name = name;
        this.type = type;
        this.numValues = numValues;
    }
    
    /**
     * Gets the attribute name.
     * 
     * @return the attribute name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the attribute type.
     * 
     * @return the attribute type
     */
    public int getType() {
        return type;
    }
    
    /**
     * Gets the number of distinct values for nominal attributes.
     * 
     * @return the number of distinct values
     */
    public int getNumValues() {
        return numValues;
    }
}
