package control;

import elements.Element;
import elements.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import utils.Position;

/**
 * Projeto de POO 2017
 * 
 * @author Luiz Eduardo
 * Baseado em material do Prof. Jose Fernando Junior
 */
public class GameController {
    
    Timer timerPoder = new Timer();
    boolean poderAtivado = false;
    boolean gameOver = false;
    FimPoder f;
    
    // Imprime todos os elementos na tela chamando a função autoDraw de cada um deles.
    // Recebe um arrayList com todos os elementos.

    public void drawAllElements(ArrayList<Element> elemArray, Graphics g){
        for(int i=0; i<elemArray.size(); i++){
            elemArray.get(i).autoDraw(g);
        }
        if(elemArray.size() >= 5){
            for(int i = 1; i < 5; i++)
                elemArray.get(i).autoDraw(g);
        }
        f = new FimPoder(elemArray);
        
    }

    
    public void processAllElements(ArrayList<Element> e){
        if(e.isEmpty())
            return;
        
        Lolo lLolo = (Lolo)e.get(0);


        // Novo método de movimentação
        lLolo.correctBuggyMovement(e, this);
        
        Element eTemp;
        Ghost eAux;
        
        // Verifica todos os elementos da tela
        for(int i = 1; i < e.size(); i++){
            
            eTemp = e.get(i);
            
            // Caso o Pacman esteja sobre o elemento
            if(lLolo.overlap(eTemp)){
                

                if(eTemp instanceof Ghost){
                    if(((Ghost) eTemp).getBlue()){
                        if(!((Ghost) eTemp).getReturning()){
                            eTemp.changeImage("eyes.png");
                            lLolo.addScore(100 * (int)Math.pow(2, lLolo.getKillStreak()));
                            if(lLolo.getKillStreak() < 4){
                                lLolo.addKillStreak(1);
                            }
                            ((Ghost) eTemp).setReturning(true);
                            if(eTemp instanceof Blinky){
                                ((Ghost) eTemp).die(new Position(10,8));
                            }
                            if(eTemp instanceof Pinky){
                                ((Ghost) eTemp).die(new Position(10,9));
                            }
                            if(eTemp instanceof Inky){
                                ((Ghost) eTemp).die(new Position(10,10));
                            }
                            if(eTemp instanceof Clyde){
                                ((Ghost) eTemp).die(new Position(10,11));
                            }
                        }
                    }
                }
                
                // Verifica se o elemento é transponível, se sim, passa por cima
                if(eTemp.isTransposable()){
                    e.remove(eTemp);
                    
                    // Se for um pacdot (10 pontos), reduz o contador de controle
                    if(eTemp instanceof PacDot){
                        lLolo.totalDots--;
                    }
                    
                    //Se for uma powerpallet (50 pontos), reduz o contador e habilita o poder
                    if(eTemp instanceof PowerPallet){
                        lLolo.totalDots--;
                        timerPoder.cancel();
                        timerPoder = new Timer();
                        timerPoder.schedule(new FimPoder(e), 7000);
                        poderAtivado = true;
                        if(lLolo.getKillStreak() == 0){
                            lLolo.setKillStreak(1);
                        }
                            eAux = (Blinky)e.get(1);
                            if(!eAux.getReturning())
                                eAux.changeImage("blue-ghost.png");
                            eAux.setBlue(true);
                            eAux.setMortal(false);
                            eAux = (Pinky) e.get(2);
                            if(!eAux.getReturning())
                                eAux.changeImage("blue-ghost.png");
                            eAux.setBlue(true);
                            eAux.setMortal(false);
                            eAux = (Inky) e.get(3);
                            if(!eAux.getReturning())
                                eAux.changeImage("blue-ghost.png");
                            eAux.setBlue(true);
                            eAux.setMortal(false);
                            eAux = (Clyde) e.get(4);
                            if(!eAux.getReturning())
                                eAux.changeImage("blue-ghost.png");
                            eAux.setBlue(true);
                            eAux.setMortal(false);
                    }
                    
                    if(eTemp instanceof Fruit){
                       ((Fruit) eTemp).isEaten = true;
                    }
                    // Adiciona o score baseado no tipo de elemento
                    lLolo.addScore(eTemp.getScore());
                }
                // Verifica se o elemento é mortal, se sim, mata o pacman
                if(eTemp.isMortal()){
                    f.run();
                    lLolo.pacmanDies(e);
                    if (lLolo.getLife() < 0) {
                        gameOver = true;
                    }
                    
                }
            }
            if(eTemp instanceof Ghost){
                if(((Ghost) eTemp).getReturning()){                                          
                    if(eTemp instanceof Blinky){
                        ((Ghost) eTemp).die(new Position(10,8));
                    }
                    else if(eTemp instanceof Pinky){
                        ((Ghost) eTemp).die(new Position(10,9));
                    }
                    else if(eTemp instanceof Inky){
                        ((Ghost) eTemp).die(new Position(10,10));
                    }
                    else if(eTemp instanceof Clyde){
                        ((Ghost) eTemp).die(new Position(10,11));
                    }
                    
                } else {
                    ((Ghost) eTemp).ai(e, lLolo, this);
                }
            }
            
        }
        // Verifica se ganha vida extra
        if (lLolo.getScore() >= lLolo.getExtraLivesFactor()) {
            // Adiciona uma vida extra
            lLolo.addLife(1);
            // A proxima vida é adicionada somente apos mais 10000 pontos
            lLolo.addExtraLivesFactor(10000);
        }
        lLolo.move();
    }

    // Uma função que recebe um array de elementos e verifica se cada um deles é transponível
    // para determinar se a posição onde ele está é válida para o Pacman
    public boolean isValidPosition(ArrayList<Element> elemArray, Element elem){
        Element elemAux;
        Lolo lolo = (Lolo) elemArray.get(0);
        for(int i = 1; i < elemArray.size(); i++){
            elemAux = elemArray.get(i);
            if(elemAux instanceof Ghost){
                continue;
            }
            if(!elemAux.isTransposable())
                if(elemAux.overlap(elem))
                    return false;
        }        
        return true;
    }
    
    public class FimPoder extends TimerTask{
        ArrayList<Element> e;
        Ghost eAux;
        Lolo loloAux;
        
        public FimPoder(ArrayList<Element> e){
            this.e = e;
        }
        
        public void run(){
            loloAux = (Lolo) e.get(0);
            loloAux.setKillStreak(0);
            poderAtivado = false;
            eAux = (Blinky) e.get(1);
            eAux.changeImage("blinky.png");
            eAux.setBlue(false);
            if(!eAux.getReturning())
                eAux.setMortal(true);
            eAux = (Pinky) e.get(2);
            eAux.changeImage("pinky.png");
            eAux.setBlue(false);
            if(!eAux.getReturning())
                eAux.setMortal(true);
            eAux = (Inky) e.get(3);
            eAux.changeImage("inky.png");
            eAux.setBlue(false);
            if(!eAux.getReturning())
                eAux.setMortal(true);
            eAux = (Clyde) e.get(4);
            eAux.changeImage("clyde.png");
            eAux.setBlue(false);
            if(!eAux.getReturning())
                eAux.setMortal(true);
        }
    }
    
 
    
}
