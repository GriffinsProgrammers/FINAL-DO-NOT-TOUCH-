// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSpinners;

public class Boost extends CommandBase {
  SwerveSpinners spinners;

  /** Creates a new Boost. */
  public Boost(SwerveSpinners spinners) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.spinners = spinners;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    spinners.setCurrLimit(60);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    spinners.setCurrLimit(30);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
