class DocumentsController < ApplicationController
  def create
    document = Document.new(title: "Document #{SecureRandom.uuid}")
    document.save!

    render json: document.to_json
  end

  def index
    document = Document.first
    render json: document.to_json
  end
end
