/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutoMove;
import frc.robot.commands.LimelightStuff.LimeLightDriveAlign;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlign;
import frc.robot.commands.ShooterManual.Belt;
import frc.robot.commands.ShooterManual.IntakeRun;
import frc.robot.commands.ShooterManual.ShooterAim;
import frc.robot.commands.ShooterManual.ShooterShoot;
import frc.robot.subsystems.UpAndDown;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick playstationController = new Joystick(RobotMap.DRIVER_CONTROLLER);
  Button buttonCircle = new JoystickButton(playstationController, 3);
  Button buttonX = new JoystickButton(playstationController, 2);
  Button buttonSquare = new JoystickButton(playstationController, 1);
  Button buttonTriangle = new JoystickButton(playstationController, 4);
  Button buttonLeftBumper = new JoystickButton(playstationController, 5);
  Button buttonRightBumper = new JoystickButton(playstationController, 6);
  Button touchPad = new JoystickButton(playstationController, 14);
  Button buttonOptions = new JoystickButton(playstationController, 10);
  public OI(){

    buttonCircle.whileHeld(new ShooterAim(0.2));
    buttonX.whileHeld(new ShooterAim(-0.2));
    buttonSquare.whileHeld(new ShooterShoot(0.6));
    buttonTriangle.whileHeld(new ShooterShoot(-0.3));
    buttonLeftBumper.whileHeld(new Belt(1));
    buttonRightBumper.whileHeld(new Belt(-1));
    touchPad.whileHeld(new LimeLightDriveAlign());
    buttonOptions.whileHeld(new LimeLightShooterAlign());
    
     }

 
  //// CREATING BUTTONS

  public double GetDriverRawStickAxis(int stickAxis){
    return playstationController.getRawAxis(stickAxis);
     }

     public double GetDriverRawTriggerAxis(int triggerAxis){
      if (playstationController.getRawAxis(triggerAxis) < 0) {
        return 0;
      } else {
        return playstationController.getRawAxis(triggerAxis);
      }
    }
   

    
    
  
}
