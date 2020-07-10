package program.renderer;

import program.FrameCounter;
import program.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;
    FrameCounter renderCounter;
    boolean isOnce;

    public AnimationRenderer(String directoryPath) {
        images = SpriteUtils.loadImages(directoryPath);
        currentImageIndex = 0;
    }

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this(images,6,false);
    }

    public AnimationRenderer(ArrayList<BufferedImage> images,int nextImageCount){
        this(images,nextImageCount,false);
    }
    public AnimationRenderer(ArrayList<BufferedImage> images, int nextImageCount, boolean isOnce) {
        this.images = images;
        this.currentImageIndex = 0;
        this.renderCounter = new FrameCounter(nextImageCount);
        this.isOnce = isOnce;

    }

    int count = 0;
    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage currentImage = images.get(currentImageIndex);
        g.drawImage(currentImage,
                (int)(master.position.x - master.anchor.x*currentImage.getWidth()) ,
                (int)(master.position.y-master.anchor.y*currentImage.getHeight()),
                null);
        count++;
        if(count>5){
            currentImageIndex++;
            if(currentImageIndex >= images.size()){
                currentImageIndex = 0;
            }
            count = 0;
        }
//        BufferedImage currentImage = this.images.get(this.currentImageIndex);
//        g.drawImage(currentImage,
//                (int)(master.position.x - master.anchor.x*currentImage.getWidth()),
//                (int)(master.position.y - master.anchor.y*currentImage.getHeight()),
//                null
//        );
//        if(this.renderCounter.count()){
//            this.currentImageIndex++;
//            if(this.currentImageIndex >= this.images.size()){
//                if(this.isOnce){
//                    master.deactive();
//                }
//                this.currentImageIndex = 0;
//            }
//            this.renderCounter.reset();
//        }
    }
}
