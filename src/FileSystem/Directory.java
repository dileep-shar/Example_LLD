package FileSystem;

import java.util.ArrayList;

public class Directory extends Node{
    ArrayList<Node> children;

    public Directory(String name,Node par){
        if(par==null) this.setPath("/");
        String parentPath = par.getPath();
        this.setPath(parentPath+"/"+name);
//        this.setID(ge);

    }
    @Override
    void setPath(String str) {

    }

    @Override
    String getPath() {
        return null;
    }
}
