
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Drive extends Command {
  public Drive() {
   requires(Robot.m_DriveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

  
    double leftSpeed = 1;
    double rightSpeed = 1; ;
    double leftStickX = Robot.m_oi.GetDriverRawStickAxis(RobotMap.LEFT_STICK_X);
    double LeftTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.LEFT_TRIGGER_PORT);
    double RightTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.RIGHT_TRIGGER_PORT);
    double Speed;
		double turn = 2 * leftStickX;
    Speed = LeftTrigger - RightTrigger;
    double limiter = 0.5;
    String move = "";
		if (leftStickX > 0.1) {

			leftSpeed = Speed;
      rightSpeed = Speed - (turn * Speed);
			move = "Left Turn ";
		} else if (leftStickX < -0.1) {

      leftSpeed = Speed + (turn * Speed);
			rightSpeed = Speed;
			move = "Right Turn ";
		} else {
      leftSpeed = Speed;
      rightSpeed = Speed;
			move = "Straight ";
    }
   // System.out.println("Driving");
    Robot.m_DriveTrain.setLeftMotorBack(leftSpeed * -limiter);
    Robot.m_DriveTrain.setLeftMotorFront(leftSpeed * -limiter);
    Robot.m_DriveTrain.setRightMotorBack(leftSpeed * limiter);
    Robot.m_DriveTrain.setRightMotorFront(leftSpeed * limiter);
  }
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_DriveTrain.setLeftMotorBack(0);
        Robot.m_DriveTrain.setRightMotorBack(0);
        Robot.m_DriveTrain.setLeftMotorFront(0);
		Robot.m_DriveTrain.setRightMotorFront(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
