require 'pycall/import'
include PyCall::Import

pyfrom 'vtkmodules.vtkFiltersSources', import: :vtkConeSource
pyfrom 'vtkmodules.vtkRenderingCore', import: %i[
  vtkPolyDataMapper vtkActor vtkRenderer
  vtkRenderWindow vtkRenderWindowInteractor
]
pyimport 'vtkmodules.vtkRenderingOpenGL2', as: :vtkRenderingOpenGL2
pyimport 'vtkmodules.vtkInteractionStyle', as: :vtkInteractionStyle

cone = vtkConeSource.new
cone.SetResolution(8)

mapper = vtkPolyDataMapper.new
mapper.SetInputConnection(cone.GetOutputPort())

actor = vtkActor.new
actor.SetMapper(mapper)

renderer = vtkRenderer.new
renderer.AddActor(actor)
renderer.SetBackground(0.2, 0.3, 0.4)

window = vtkRenderWindow.new
window.AddRenderer(renderer)
window.SetSize(640, 480)

interactor = vtkRenderWindowInteractor.new
interactor.SetRenderWindow(window)

window.Render
interactor.Start
