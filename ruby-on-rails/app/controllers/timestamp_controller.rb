class TimestampController < ApplicationController

  def timestamp
    render json: { timestamp: Time.now.to_i }
  end

end
