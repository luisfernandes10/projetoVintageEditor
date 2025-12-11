import pt.iscte.greyditor.Greyditor;

void main() {
    Greyditor configuration = new Greyditor("VintageEditor");

    // Phase 1
    configuration.addFilter("Brightness", Filters::brightness, -255, 255);
    configuration.addFilter("Contrast", Filters::contrast, 0, 100);
    configuration.addEffect("Horizontal Flip", Effect::horizontalFlip);
    configuration.addEffect("Vertical Flip", Effect::verticalFlip);
    configuration.addFilter("Grain", Filters::grain, 0, 150);
    configuration.addEffect("Margin", Effect::margin);
    configuration.addEffect("Vignette", Effect::vignette, 0, 100);

    // Phase 2
    configuration.addOperation("Crop", Operations::crop);
    configuration.addOperation("Expand", Operations::expand);
    configuration.addFilter("Posterize", Filters::posterize);
    configuration.addOperation("Rotate", Operations::rotate);
    configuration.addEffect("Blur", Effect::blur, 0, 5);
    configuration.addOperation("Old", Operations::old);
    configuration.addOperation("Retro", Operations::retro);

    // Phase 3
    configuration.addOperation("Copy", Operations::copy);
    configuration.addOperation("Cut", Operations::cut);
    configuration.addOperation("Paste", Operations::paste);
    configuration.addOperation("Undo", Operations::undo);

    configuration.open("monalisa.jpg");
}