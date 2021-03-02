
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Drive extends CommandBase {
  public Drive() {
    addRequirements(Robot.m_DriveTrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    double leftSpeed = 1;
    double rightSpeed = 1;
    double leftStickX = Robot.m_oi.GetDriverRawStickAxis(RobotMap.LEFT_STICK_X);
    double LeftTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.LEFT_TRIGGER_PORT);
    double RightTrigger = Robot.m_oi.GetDriverRawTriggerAxis(RobotMap.RIGHT_TRIGGER_PORT);
    double Speed = LeftTrigger - RightTrigger;
    double turn = 2 * leftStickX;
    if (leftStickX > RobotMap.DEADZONE) {

      leftSpeed = Speed;
      rightSpeed = Speed - (turn * Speed);
    } else if (leftStickX < -RobotMap.DEADZONE) {

      leftSpeed = Speed + (turn * Speed);
      rightSpeed = Speed;
    } else {

      leftSpeed = Speed;
      rightSpeed = Speed;
    }
    // System.out.println("Driving");
    Robot.m_DriveTrain.tankDrive(leftSpeed * -RobotMap.LIMITER, rightSpeed * -RobotMap.LIMITER);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.m_DriveTrain.setAll(0);
  }
}
