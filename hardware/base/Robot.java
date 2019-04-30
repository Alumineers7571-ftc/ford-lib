package org.firstinspires.ftc.teamcode.lib.hardware.base;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.lib.coordinates.*;
import org.firstinspires.ftc.teamcode.lib.util.Math7571;
import org.firstinspires.ftc.teamcode.lib.util.PIDController;

public class Robot{

  private DcMotor fl, fr, bl, br;

  public Position position;

  public Robot(){

    InitDT();
    InitPID();

  }

  private void InitPID(){

    PIDController pid = new PIDController(0.001, 0, 0);

    pid.setOutputLimits(1);
    pid.setSetpoint(5);

  }

  private void InitDT(){

  }

  public void DriveByPower(double power){
    
  }

  public void DriveEncoders(double distance){
    System.out.println("distance: " + distance);
  }

  public void DrivePID(double distance){

      


  }

  public void TurnGyro(double targetHeading){

  }

  public void move(Position pos){

    System.out.println("current: " + position.getCurrent() + " target: " + pos.getTarget());

    double targetHeading = Math7571.calculateHeading(pos.getMovements(position.getCurrent(), pos.getTarget()));

    TurnGyro(targetHeading);//absolute radians -pi to pi(please next year start on a divisible by PI/2 angle!!!)
    DrivePID(Math7571.calcHyp(position.getCurrent(), pos.getTarget()));

    System.out.println("heading: " + Math.toDegrees(targetHeading));

    position.setCurrent(pos.getTarget());
    //change this to actual? or just compare in testing and then mess with PID to close the gap?

  }


}