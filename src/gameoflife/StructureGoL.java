/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Mateusz
 */
public class StructureGoL {
    private boolean[][] spaceToLive; 
    public StructureGoL(int sizeX, int sizeY)
    {
        spaceToLive = new boolean[sizeX][sizeY];
        
    
    }
    public StructureGoL(boolean[][] space)
    {
        spaceToLive = space;
    }
    public void setAlive(int coordinateX, int coordinateY)throws ArrayIndexOutOfBoundsException
    {
        spaceToLive[coordinateX][coordinateY] = true;
    }
    public void setDead(int coordinateX, int coordinateY)throws ArrayIndexOutOfBoundsException
    {
        spaceToLive[coordinateX][coordinateY] = false;
    }
    public boolean getAt(int coordinateX, int coordinateY) throws ArrayIndexOutOfBoundsException
    {
        return spaceToLive[coordinateX][coordinateY];
            
    }
    public boolean[][] getBoard()
    {
        return spaceToLive;
    }
    public void nextLivingStage()
    {
        boolean[][] nextStageBoard = new boolean[spaceToLive.length][spaceToLive[0].length];
        for(int XAxis=0; XAxis < spaceToLive.length; XAxis++)
        {
            for(int YAxis=0; YAxis < spaceToLive[0].length; YAxis++)
            {
                int howManyAlive = 0;
                if(XAxis != 0)
                {
                    howManyAlive += spaceToLive[XAxis-1][YAxis] ? 1:0;
                }
                if(YAxis != 0)
                {
                    howManyAlive += spaceToLive[XAxis][YAxis-1]?1:0;
                }
                if(XAxis != spaceToLive.length-1)
                {
                    howManyAlive += spaceToLive[XAxis+1][YAxis]?1:0;
                }
                if(YAxis != spaceToLive[0].length-1)
                {
                    howManyAlive += spaceToLive[XAxis][YAxis+1]?1:0;
                }
                if(XAxis !=0 && YAxis != 0)
                {
                    howManyAlive += spaceToLive[XAxis-1][YAxis-1] ? 1 : 0;
                }
                if(XAxis != spaceToLive.length-1 && YAxis != 0)
                {
                    howManyAlive += spaceToLive[XAxis+1][YAxis-1] ? 1 : 0;
                }
                if(XAxis != spaceToLive.length-1 && YAxis != spaceToLive[0].length-1)
                {
                    howManyAlive += spaceToLive[XAxis+1][YAxis+1] ? 1 : 0;
                }
                if(XAxis != 0 && YAxis != spaceToLive[0].length-1)
                {
                    howManyAlive += spaceToLive[XAxis-1][YAxis+1] ? 1 : 0;
                }
                
                if (howManyAlive == 2&& getAt(XAxis,YAxis))
                {
                    nextStageBoard[XAxis][YAxis] = true;
                }
                if(howManyAlive == 3)
                {
                    nextStageBoard[XAxis][YAxis] = true;
                }
                
            }
        }
        spaceToLive = nextStageBoard;
    }
    @Override
    public String toString()
    {
        StringBuilder result= new StringBuilder();
        for(boolean[] row: spaceToLive)
        {
            for(boolean cell: row)
            {
                result.append(cell ? "O":"X");
            }
            result.append("\n");
        }
        
        return result.toString();
    }
}
