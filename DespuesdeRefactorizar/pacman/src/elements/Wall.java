/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;
/**
 *
 * @author tiago
 */
public class Wall extends BackgroundElement {

    public Wall(String imageName) {
        super(imageName);
        this.isTransposable = false;
    }

    /*
    @Override
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    */
    
}
