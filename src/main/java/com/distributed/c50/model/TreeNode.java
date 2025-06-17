package com.distributed.c50.model;

/**
 * Class representing a node in the decision tree.
 * Standalone implementation to avoid compilation issues with inner classes.
 */
public class TreeNode {
    private boolean isLeaf;
    private int attributeIndex;
    private String attributeName;
    private TreeNode[] children;
    private int[] classDistribution;
    
    /**
     * Creates a new tree node.
     */
    public TreeNode() {
        this.isLeaf = false;
        this.attributeIndex = -1;
        this.attributeName = null;
        this.children = null;
        this.classDistribution = null;
    }
    
    /**
     * Checks if this is a leaf node.
     * 
     * @return true if this is a leaf node, false otherwise
     */
    public boolean isLeaf() {
        return isLeaf;
    }
    
    /**
     * Sets whether this is a leaf node.
     * 
     * @param isLeaf true if this is a leaf node, false otherwise
     */
    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
    
    /**
     * Gets the attribute index for this node.
     * 
     * @return the attribute index
     */
    public int getAttributeIndex() {
        return attributeIndex;
    }
    
    /**
     * Sets the attribute index for this node.
     * 
     * @param attributeIndex the attribute index
     */
    public void setAttributeIndex(int attributeIndex) {
        this.attributeIndex = attributeIndex;
    }
    
    /**
     * Gets the attribute name for this node.
     * 
     * @return the attribute name
     */
    public String getAttributeName() {
        return attributeName;
    }
    
    /**
     * Sets the attribute name for this node.
     * 
     * @param attributeName the attribute name
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    
    /**
     * Gets the child nodes.
     * 
     * @return array of child nodes
     */
    public TreeNode[] getChildren() {
        return children;
    }
    
    /**
     * Sets the child nodes.
     * 
     * @param children array of child nodes
     */
    public void setChildren(TreeNode[] children) {
        this.children = children;
    }
    
    /**
     * Gets the class distribution for this node.
     * 
     * @return array of class counts
     */
    public int[] getClassDistribution() {
        return classDistribution;
    }
    
    /**
     * Sets the class distribution for this node.
     * 
     * @param classDistribution array of class counts
     */
    public void setClassDistribution(int[] classDistribution) {
        this.classDistribution = classDistribution;
    }
    
    /**
     * Gets the majority class for this node.
     * 
     * @return the majority class index
     */
    public int getMajorityClass() {
        if (classDistribution == null || classDistribution.length == 0) {
            return -1;
        }
        
        int majorityClass = 0;
        int maxCount = classDistribution[0];
        
        for (int i = 1; i < classDistribution.length; i++) {
            if (classDistribution[i] > maxCount) {
                maxCount = classDistribution[i];
                majorityClass = i;
            }
        }
        
        return majorityClass;
    }
    
    /**
     * Returns a string representation of this node.
     * 
     * @return a string representation
     */
    @Override
    public String toString() {
        if (isLeaf) {
            return "Leaf Node: Class Distribution = " + classDistributionToString();
        } else {
            return "Decision Node: Attribute = " + attributeName + " (" + attributeIndex + ")";
        }
    }
    
    /**
     * Converts the class distribution to a string.
     * 
     * @return a string representation of the class distribution
     */
    private String classDistributionToString() {
        if (classDistribution == null) {
            return "null";
        }
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < classDistribution.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(classDistribution[i]);
        }
        sb.append("]");
        
        return sb.toString();
    }
}
