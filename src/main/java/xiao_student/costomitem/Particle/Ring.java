package xiao_student.costomitem.Particle;

import org.bukkit.Location;
import org.bukkit.Particle;

public class Ring implements ParticlePlayalble {

    private Location location;
    private double radius;
    private double y;
    private int count;

    /**
     * 环的初始化
     * @param location 坐标
     * @param radius 半径
     * @param y 高度
     * @param count 数量
     */
    public Ring(Location location, double radius, double y, int count) {
        this.location = location;
        this.radius = radius;
        this.y = y;
        this.count = count;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void particlePlay() {

        //设一个半径为1的圆为单位圆
        //设一个点做垂线得到三角形
        //通过cosX 可以获得斜边长度
        //sinX,可以获得邻边长度
        //通过长度获取XY坐标
        //增加角度

        double radius = 1.5;
        for (int degree = 0; degree < 360; degree += 8) {
            //坐标转为弧度制
            double radians = Math.toRadians(degree);
            double x = radius * Math.cos(radians);
            double z = radius * Math.sin(radians);

            location.add(x, y, z);
            location.getWorld().spawnParticle(Particle.FLAME, location, count);
            location.subtract(x, y, z);
        }

    }

    @Override
    public ParticlePlayalble getParticle() {
        return this;
    }
}
