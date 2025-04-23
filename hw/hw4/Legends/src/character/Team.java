/**
 * Team.java
 * by Yifei Bao (baoyifei@bu.edu)
 * 11/5/2024
 *
 * This abstract class defines a general team with attributes
 * like name, row, col and count.
 * It also has abstract methods to generate a team.
 */


package character;

public abstract class Team {
    protected String name;
    protected int row;
    protected int col;
    protected int count;

    protected Team(String name){
        this(name, 0, 0, 1);
    }

    protected Team(String name, int row, int col, int count){
        this.name = name;
        this.row = row;
        this.col = col;
        this.count = count;
        generateTeam();
    }

    public abstract void generateTeam();

    public String getName(){
        return name;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getCount(){
        return count;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }
}
