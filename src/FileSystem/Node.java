package FileSystem;

public abstract class Node {
    private String name;
    private int id;
    private Node parent;

    private String path;
    private boolean isHardLink;

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public Node getParent() {
        return parent;
    }

    abstract void setPath(String str);

    String getPath() {
        return this.path;
    }


}
