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
import frc.robot.commands.ShooterManual.ShooterAim;
import frc.robot.commands.ShooterManual.ShooterIntake;
import frc.robot.commands.ShooterManual.ShooterShoot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public OI(){

    buttonCircle.whenPressed(new ShooterAim(0.5, true));
    buttonX.whenPressed(new ShooterAim(-0.5, false));
    buttonSquare.whenPressed(new ShooterShoot(0.5, false));
    buttonTriangle.whenPressed(new ShooterShoot(0.5, true));
     }
     
  Joystick playstationController = new Joystick(RobotMap.DRIVER_CONTROLLER);
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
    Button buttonCircle = new JoystickButton(playstationController, 1);
    Button buttonX = new JoystickButton(playstationController, 2);
    Button buttonSquare = new JoystickButton(playstationController, 3);
    Button buttonTriangle = new JoystickButton(playstationController, 4);

    
    
  
}
