package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeSubsystem;

/**
 * Not sure this functionality has any use, but might as well.
 */
public class IntakeCommand extends Command {
    private final IntakeSubsystem intake;

    public IntakeCommand(IntakeSubsystem subsystem) {
        this.intake = subsystem;
    }

    @Override
    public void initialize() {
        this.intake.stop();
    }

    @Override
    public void execute() {
        this.intake.drive(-0.8);
    }

    @Override
    public void end(boolean interrupted) {
        this.intake.stop();
    }
}
