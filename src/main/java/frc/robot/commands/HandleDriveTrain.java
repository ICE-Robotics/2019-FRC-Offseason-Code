/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Utilities;

/**
 * Handle the Drivetrain
 */
public class HandleDriveTrain extends Command{

  public HandleDriveTrain() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
      Robot.drivetrain.drive(0, 0); // Don't move on init
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (!Robot.inAuto()) {
      Robot.drivetrain.drive(-1 * Utilities.applyDeadband(Robot.m_oi.getLeftJoy().getRawAxis(1), 0.1),
                             -1 * Utilities.applyDeadband(Robot.m_oi.getRightJoy().getRawAxis(1), 0.1)); // Drive with Joysticks
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.endDrive){
      return true;
    } else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
