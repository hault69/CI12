package game;

public class Vector2D {
    public float x;
    public float y;
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D orther)
    {
        return this.set(orther.x,orther.y);
    }

    public Vector2D add(float x, float y){
        return new Vector2D(this.x+x,this.y+y);
    }

    public Vector2D add(Vector2D orther){
        return this.add(orther.x,orther.y);
    }

    public Vector2D addThis(float x, float y){
        this.x +=x;
        this.y +=y;
        return this;
    }

    public Vector2D addThis(Vector2D orther){
        return this.addThis(orther.x, orther.y);
    }

    public Vector2D substract(float x, float y){
        return new Vector2D(this.x-x,this.y-y);
    }

    public Vector2D substract( Vector2D orther){
        return this.substract(orther.x,orther.y);
    }

    public Vector2D substractThis(float x, float y){
        this.x -=x;
        this.y -=y;
        return this;
    }

    public Vector2D substractThis(Vector2D orther){
        return substractThis(orther.x,orther.y);
    }

    public Vector2D scale(float rate){
        return new Vector2D(this.x*rate,this.y*rate);
    }

    public Vector2D scaleThis(float rate){
        this.x *= rate;
        this.y *= rate;
        return this;
    }

    public float getLength(){
        return(float)Math.sqrt(this.x*this.x*this.y*this.y);
    }

    public Vector2D setlength( float length){
        if (this.getLength() ==0 ){
            return this;
        }
        float rate = length / this.getLength();
        this.x = this.x * rate;
        this.y = this.y * rate;
        return this;
    }

    public float getAngle(){
        return (float)Math.atan(this.y/this.x);
    }

    public Vector2D setAngle(float angle){
        float length = this.getLength();
        this.x =  length * (float)Math.cos(angle);
        this.y = length * (float)Math.sin(angle);
        return this;
    }

}
