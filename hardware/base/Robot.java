package org.firstinspires.ftc.teamcode.lib.hardware.base;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.lib.coordinates.*;
import org.firstinspires.ftc.teamcode.lib.util.Math7571;
import org.firstinspires.ftc.teamcode.lib.util.PIDController;

public class Robot{

  private DcMotor fl, fr, bl, br;
  private PIDController pidRotate, pidDrive;

  private int[] pose = {0,0,0};

  public Position position;

  public Robot(){

    initDT();
    initPID();

  }

  private void initPID(){

    pidRotate = new PIDController(0.001, 0, 0);
    pidDrive = new PIDController(0.001, 0, 0);

    pidRotate.setOutputLimits(1);
    pidRotate.setSetpoint(0);

  }

  private void initDT(){

  }

  public void driveByPower(double power){
    
    fl.setPower(power);
    fr.setPower(power);
    bl.setPower(power);
    br.setPower(power);

  }

  public void driveInches(double distance){
    System.out.println("distance: " + distance);
  }

  public void drivePID(double distance){

  }

  public void turnGyro(double targetHeading){

  }

  public void movePos(Position pos){

    System.out.println("current: " + position.getCurrent() + " target: " + pos.getTarget());

    double targetHeading = Math7571.calculateHeading(pos.getMovements(position.getCurrent(), pos.getTarget()));

    turnGyro(targetHeading);//absolute radians -pi to pi(please next year start on a divisible by PI/2 angle!!!)
    drivePID(Math7571.calcHyp(position.getCurrent(), pos.getTarget()));

    System.out.println("heading: " + Math.toDegrees(targetHeading));

    position.setCurrent(pos.getTarget());
    //change this to actual? or just compare in testing and then mess with PID to close the gap?

  }

  public int[] getPose(){

    return pose;
  }

  public void calcPose(){

  }

  public void bulkRead(){
    
  }


}